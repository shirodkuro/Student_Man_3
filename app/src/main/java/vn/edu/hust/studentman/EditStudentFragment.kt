package vn.edu.hust.studentman

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class EditStudentFragment : Fragment() {

    private val args: EditStudentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEditText = view.findViewById<EditText>(R.id.edit_hoten)
        val idEditText = view.findViewById<EditText>(R.id.edit_mssv)
        val saveButton = view.findViewById<Button>(R.id.button_save)

        // Pre-fill the EditText fields with the selected student's information
        nameEditText.setText(args.studentName)
        idEditText.setText(args.studentId)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()
            // Logic to update student information
            findNavController().navigateUp()
        }
    }
}