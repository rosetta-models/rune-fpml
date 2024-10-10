package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Leg;
import fpml.confirmation.validation.LegTypeFormatValidator;
import fpml.confirmation.validation.LegValidator;
import fpml.confirmation.validation.exists.LegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Leg.class)
public class LegMeta implements RosettaMetaData<Leg> {

	@Override
	public List<Validator<? super Leg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Leg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Leg> validator() {
		return new LegValidator();
	}

	@Override
	public Validator<? super Leg> typeFormatValidator() {
		return new LegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Leg, Set<String>> onlyExistsValidator() {
		return new LegOnlyExistsValidator();
	}
}
