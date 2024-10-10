package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditDocument;
import fpml.confirmation.validation.CreditDocumentTypeFormatValidator;
import fpml.confirmation.validation.CreditDocumentValidator;
import fpml.confirmation.validation.exists.CreditDocumentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditDocument.class)
public class CreditDocumentMeta implements RosettaMetaData<CreditDocument> {

	@Override
	public List<Validator<? super CreditDocument>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditDocument, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditDocument> validator() {
		return new CreditDocumentValidator();
	}

	@Override
	public Validator<? super CreditDocument> typeFormatValidator() {
		return new CreditDocumentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditDocument, Set<String>> onlyExistsValidator() {
		return new CreditDocumentOnlyExistsValidator();
	}
}
