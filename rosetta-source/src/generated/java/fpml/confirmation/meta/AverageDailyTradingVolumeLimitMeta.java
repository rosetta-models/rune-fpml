package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AverageDailyTradingVolumeLimit;
import fpml.confirmation.validation.AverageDailyTradingVolumeLimitTypeFormatValidator;
import fpml.confirmation.validation.AverageDailyTradingVolumeLimitValidator;
import fpml.confirmation.validation.exists.AverageDailyTradingVolumeLimitOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AverageDailyTradingVolumeLimit.class)
public class AverageDailyTradingVolumeLimitMeta implements RosettaMetaData<AverageDailyTradingVolumeLimit> {

	@Override
	public List<Validator<? super AverageDailyTradingVolumeLimit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AverageDailyTradingVolumeLimit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AverageDailyTradingVolumeLimit> validator() {
		return new AverageDailyTradingVolumeLimitValidator();
	}

	@Override
	public Validator<? super AverageDailyTradingVolumeLimit> typeFormatValidator() {
		return new AverageDailyTradingVolumeLimitTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AverageDailyTradingVolumeLimit, Set<String>> onlyExistsValidator() {
		return new AverageDailyTradingVolumeLimitOnlyExistsValidator();
	}
}
