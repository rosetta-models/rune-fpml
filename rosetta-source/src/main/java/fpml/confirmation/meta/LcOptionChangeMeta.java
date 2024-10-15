package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcOptionChange;
import fpml.confirmation.validation.LcOptionChangeTypeFormatValidator;
import fpml.confirmation.validation.LcOptionChangeValidator;
import fpml.confirmation.validation.exists.LcOptionChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LcOptionChange.class)
public class LcOptionChangeMeta implements RosettaMetaData<LcOptionChange> {

	@Override
	public List<Validator<? super LcOptionChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcOptionChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcOptionChange> validator() {
		return new LcOptionChangeValidator();
	}

	@Override
	public Validator<? super LcOptionChange> typeFormatValidator() {
		return new LcOptionChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcOptionChange, Set<String>> onlyExistsValidator() {
		return new LcOptionChangeOnlyExistsValidator();
	}
}
