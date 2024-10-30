package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ValuationDocument;
import fpml.confirmation.validation.ValuationDocumentTypeFormatValidator;
import fpml.confirmation.validation.ValuationDocumentValidator;
import fpml.confirmation.validation.exists.ValuationDocumentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ValuationDocument.class)
public class ValuationDocumentMeta implements RosettaMetaData<ValuationDocument> {

	@Override
	public List<Validator<? super ValuationDocument>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationDocument, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ValuationDocument> validator() {
		return new ValuationDocumentValidator();
	}

	@Override
	public Validator<? super ValuationDocument> typeFormatValidator() {
		return new ValuationDocumentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationDocument, Set<String>> onlyExistsValidator() {
		return new ValuationDocumentOnlyExistsValidator();
	}
}
