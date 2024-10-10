package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexReferenceInformationSequence1;
import fpml.confirmation.validation.IndexReferenceInformationSequence1TypeFormatValidator;
import fpml.confirmation.validation.IndexReferenceInformationSequence1Validator;
import fpml.confirmation.validation.exists.IndexReferenceInformationSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IndexReferenceInformationSequence1.class)
public class IndexReferenceInformationSequence1Meta implements RosettaMetaData<IndexReferenceInformationSequence1> {

	@Override
	public List<Validator<? super IndexReferenceInformationSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexReferenceInformationSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IndexReferenceInformationSequence1> validator() {
		return new IndexReferenceInformationSequence1Validator();
	}

	@Override
	public Validator<? super IndexReferenceInformationSequence1> typeFormatValidator() {
		return new IndexReferenceInformationSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexReferenceInformationSequence1, Set<String>> onlyExistsValidator() {
		return new IndexReferenceInformationSequence1OnlyExistsValidator();
	}
}
