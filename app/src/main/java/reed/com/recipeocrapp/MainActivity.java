package reed.com.recipeocrapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button scanRecipeActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanRecipeActivityBtn = (Button)findViewById(R.id.scanRecipeActivityBtn);

        scanRecipeActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scanRecipeActivityIntent = new Intent(getApplicationContext(), ScanRecipeActivity.class);
                startActivity(scanRecipeActivityIntent);
            }
        });
    }
}


//public class AddRecipeActivity extends AppCompatActivity {
//
//    /**
//     * Debugging Tag to display LogCat messages for debugging
//     */
//    private static final String TAG = AddRecipeActivity.class.getSimpleName();
//
//    /**
//     * Set up DatabaseAdapter and a flag for if there is correct input
//     */
//    private DatabaseAdapter dbHelper;
//
//    /**
//     * Flag to ensure all entries are filled
//     */
//    private boolean correctInput = true;
//
//    /**
//     *
//     */
//    private ArrayList<Ingredient> ingredientsForRecipe = new ArrayList<>();
//
//    /**
//     * Keep track of how many new lines there is
//     */
//    private int numNewLines;
//
//    /**
//     * Array of ids for each of he rows to keep track of what is on them
//     */
//    int ids[] = {R.id.newRow1, R.id.newRow2, R.id.newRow3, R.id.newRow4, R.id.newRow5,
//            R.id.newRow6, R.id.newRow7, R.id.newRow8, R.id.newRow9, R.id.newRow10,
//            R.id.newRow11, R.id.newRow12, R.id.newRow13, R.id.newRow14, R.id.newRow15,
//            R.id.newRow16, R.id.newRow17, R.id.newRow18, R.id.newRow19, R.id.newRow20};
//
//    /**
//     * Opens AddRecipeActivity Activity so that you can add a recipe to the cookbook
//     * <p>
//     * Adds fields to add recipe name, quantity, units, ingredients, and
//     *   instructions to the database. Sets numNewLines to 0.
//     *
//     * @param savedInstanceState save the activity for reopening
//     */
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_recipe);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        numNewLines = 0;
//        Log.i(TAG, "Started Add To Cookbook_Frag");
//        dbHelper = new DatabaseAdapter(this);
//
//        /**
//         * this must be final since it is accessed from an inner class
//         */
//        final ImageButton add = (ImageButton) findViewById(R.id.addMore);
//        final Button addRecipe = (Button) findViewById(R.id.addRecipe);
//
//        /**
//         * Add a listener to add an extra row of input fields
//         */
//        add.setOnClickListener(new View.OnClickListener() {
//
//            /**
//             * When they click the + button, they will get another row for input.
//             * <p>
//             * Insures that there in no more than 20 new lines, When the plus(+)
//             *   button is clicked, we add a new row to the View and increments
//             *   numNewLines by 1.
//             *
//             * @param view The view that was clicked.
//             */
//            @Override
//            public void onClick(View view) {
//                /**
//                 * Don't let the user enter any more than 20 new lines
//                 */
//                if (numNewLines > 19)
//                    return;
//
//                /**
//                 * We use the context of the button, since it is on the activity we are using
//                 */
//                LayoutInflater vi = (LayoutInflater) add.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View v = vi.inflate(R.layout.input_field, null); //This is the layout of the new row
//
//                /**
//                 * update id of container and then increment number of new lines
//                 */
//                v.setId(ids[numNewLines]);
//                ++numNewLines;
//
//                /**
//                 * There is an (at first) empty container LinearLayout that we insert these into
//                 */
//                ((ViewGroup) findViewById(R.id.container)).addView(v);
//
//                Log.i(TAG, "added line " + numNewLines + " with id of " + ids[numNewLines - 1]);
//            }
//        });
//
//        addRecipe.setOnClickListener(new View.OnClickListener() {
//
//            /**
//             * Adds Recipes to the database and broadcasts the changes
//             * <p>
//             * Adds recipe name, quantity, units, ingredients, and instructions to the database
//             * Checks to ensure that all of the fields are filled out.
//             * Clicking the add button adds the first row to the database
//             *
//             * @param view The view that was clicked.
//             */
//            @Override
//            public void onClick(View view) {
//                Log.i(TAG, "adding recipe");
//
//                /**
//                 * insert the name and instructions of the recipe into the DB
//                 */
//                String recName = ((EditText) findViewById(R.id.recipeName)).getText().toString();
//                recName = recName.replace("  ", " "); //remove double spaces if any
//                String recInstructions = ((EditText) findViewById(R.id.editText)).getText().toString();
//                long id = -1;
//
//                /**
//                 * Error handling for if recName and recInstructions are blank
//                 */
//                if (!recName.equals("") && !recInstructions.equals("")) {
//                    id = dbHelper.addRecipeInfo(recName, recInstructions);
//                    if (id <= 0) {
//                        Log.i(TAG, "failed to add recipe");
//                        correctInput = false;
//                        return;
//                    } else {
//                        // reset the flag
//                        correctInput = true;
//                    }
//
//                } else {
//                    correctInput = false;
//                }
//
//                /**
//                 * Ensure that the ingredients are blank
//                 */
//                Log.i(TAG, "added recipe");
//
//                /**
//                 * Input all of the ingredients the recipe was added.
//                 */
//                if (correctInput) {
//                    String ingQuant = ((EditText) findViewById(R.id.ingQuant)).getText().toString();
//                    String ingUnit = ((Spinner) findViewById(R.id.ingUnit)).getSelectedItem().toString();
//                    String ingName = ((EditText) findViewById(R.id.ingName)).getText().toString();
//                    ingName = ingName.replace("  ", " "); //remove double spaces if any
//
//                    /**
//                     * Add if there is a quantity and a name
//                     */
//                    if (!ingQuant.equals("") && !ingName.equals("")) {
//                        ingredientsForRecipe.add(new Ingredient(ingName, Integer.parseInt(ingQuant), ingUnit));
//
//                        RelativeLayout rel;
//
//                        /**
//                         * Add more ingredients if there is more than one.
//                         */
//                        for (int i = 0; i < numNewLines; ++i) {
//                            rel = ((RelativeLayout)findViewById(ids[i]));
//                            ingQuant = ((EditText)rel.findViewById(R.id.quanNewRow)).getText().toString();
//                            ingUnit = ((Spinner)rel.findViewById(R.id.unitNewRow)).getSelectedItem().toString();
//                            ingName = ((EditText)rel.findViewById(R.id.nameNewRow)).getText().toString();
//                            ingName = ingName.replace("  ", " "); //remove double spaces if any
//
//                            /**
//                             * only add them if they have something there.
//                             */
//                            if (!ingQuant.equals("") && !ingName.equals(""))
//                                ingredientsForRecipe.add(new Ingredient(ingName, Integer.parseInt(ingQuant), ingUnit));
//                        }
//                    }
//
//                    for (Ingredient ingred : ingredientsForRecipe)
//                        dbHelper.addRecipeIngredients(ingred.getName(), ingred.getQuantityString(),
//                                ingred.getMetric(), id);
//
//                    Cookbook_Frag.refreshCookbook();
//                    finish();
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "Please fill out all fields",
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
//}

/**************************************************************        Display recipe   ************************************************************************************/
//public class DisplayRecipeActivity extends AppCompatActivity {
//
//    /**
//     * Debugging Tag to display LogCat messages for debugging
//     */
//    private static final String TAG = DisplayRecipeActivity.class.getSimpleName();
//
//    /**
//     * This is the access point for the database
//     */
//    private DatabaseAdapter dbHelper;
//
//    /**
//     * This is what is called when this activity is created. It handles everything that needs to be
//     * done.
//     *
//     * @param savedInstanceState save the activity for reopening
//     */
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        /**
//         * set the content view and the database adapter.
//         */
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.display_recipe);
//        dbHelper = new DatabaseAdapter(this);
//
//        /**
//         * get the name of the selected recipe
//         */
//        String recipeName = getIntent().getStringExtra("recipeName");
//        Log.i(TAG, "Displaying recipe: " + recipeName);
//
//        /**
//         * retrieve the recipe information
//         */
//        String[] recipeInfo = dbHelper.getRecipe(recipeName);
//        Long id = Long.valueOf(recipeInfo[0]);
//        String recipeIngredients = dbHelper.getRecipeIngredients(id);
//        Log.i(TAG, "Successfully saved recipeInfo into array");
//
//        /**
//         * update text in recipe
//         */
//        TextView textView = (TextView)findViewById(R.id.recipeName);
//        textView.setText(recipeInfo[1]);
//        textView = (TextView)findViewById(R.id.recipeInstructions);
//        textView.setText(recipeInfo[2]);
//        textView = (TextView)findViewById(R.id.ingQuant);
//        textView.setText(recipeIngredients);
//    }
//}