package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DataDocument;
import fpml.confirmation.validation.DataDocumentTypeFormatValidator;
import fpml.confirmation.validation.DataDocumentValidator;
import fpml.confirmation.validation.exists.DataDocumentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DataDocument.class)
public class DataDocumentMeta implements RosettaMetaData<DataDocument> {

	@Override
	public List<Validator<? super DataDocument>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DataDocument, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DataDocument> validator() {
		return new DataDocumentValidator();
	}

	@Override
	public Validator<? super DataDocument> typeFormatValidator() {
		return new DataDocumentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DataDocument, Set<String>> onlyExistsValidator() {
		return new DataDocumentOnlyExistsValidator();
	}
}
