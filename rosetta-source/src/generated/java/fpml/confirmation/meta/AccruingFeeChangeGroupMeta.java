package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingFeeChangeGroup;
import fpml.confirmation.validation.AccruingFeeChangeGroupTypeFormatValidator;
import fpml.confirmation.validation.AccruingFeeChangeGroupValidator;
import fpml.confirmation.validation.exists.AccruingFeeChangeGroupOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AccruingFeeChangeGroup.class)
public class AccruingFeeChangeGroupMeta implements RosettaMetaData<AccruingFeeChangeGroup> {

	@Override
	public List<Validator<? super AccruingFeeChangeGroup>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeeChangeGroup, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingFeeChangeGroup> validator() {
		return new AccruingFeeChangeGroupValidator();
	}

	@Override
	public Validator<? super AccruingFeeChangeGroup> typeFormatValidator() {
		return new AccruingFeeChangeGroupTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeeChangeGroup, Set<String>> onlyExistsValidator() {
		return new AccruingFeeChangeGroupOnlyExistsValidator();
	}
}
