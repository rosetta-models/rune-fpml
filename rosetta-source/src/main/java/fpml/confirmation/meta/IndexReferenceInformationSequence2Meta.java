package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexReferenceInformationSequence2;
import fpml.confirmation.validation.IndexReferenceInformationSequence2TypeFormatValidator;
import fpml.confirmation.validation.IndexReferenceInformationSequence2Validator;
import fpml.confirmation.validation.exists.IndexReferenceInformationSequence2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IndexReferenceInformationSequence2.class)
public class IndexReferenceInformationSequence2Meta implements RosettaMetaData<IndexReferenceInformationSequence2> {

	@Override
	public List<Validator<? super IndexReferenceInformationSequence2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexReferenceInformationSequence2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IndexReferenceInformationSequence2> validator() {
		return new IndexReferenceInformationSequence2Validator();
	}

	@Override
	public Validator<? super IndexReferenceInformationSequence2> typeFormatValidator() {
		return new IndexReferenceInformationSequence2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexReferenceInformationSequence2, Set<String>> onlyExistsValidator() {
		return new IndexReferenceInformationSequence2OnlyExistsValidator();
	}
}
