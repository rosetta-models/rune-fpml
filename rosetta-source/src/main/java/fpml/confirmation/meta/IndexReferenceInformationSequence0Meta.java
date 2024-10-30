package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexReferenceInformationSequence0;
import fpml.confirmation.validation.IndexReferenceInformationSequence0TypeFormatValidator;
import fpml.confirmation.validation.IndexReferenceInformationSequence0Validator;
import fpml.confirmation.validation.exists.IndexReferenceInformationSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=IndexReferenceInformationSequence0.class)
public class IndexReferenceInformationSequence0Meta implements RosettaMetaData<IndexReferenceInformationSequence0> {

	@Override
	public List<Validator<? super IndexReferenceInformationSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexReferenceInformationSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IndexReferenceInformationSequence0> validator() {
		return new IndexReferenceInformationSequence0Validator();
	}

	@Override
	public Validator<? super IndexReferenceInformationSequence0> typeFormatValidator() {
		return new IndexReferenceInformationSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexReferenceInformationSequence0, Set<String>> onlyExistsValidator() {
		return new IndexReferenceInformationSequence0OnlyExistsValidator();
	}
}
