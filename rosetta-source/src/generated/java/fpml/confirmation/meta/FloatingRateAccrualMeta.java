package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateAccrual;
import fpml.confirmation.validation.FloatingRateAccrualTypeFormatValidator;
import fpml.confirmation.validation.FloatingRateAccrualValidator;
import fpml.confirmation.validation.exists.FloatingRateAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FloatingRateAccrual.class)
public class FloatingRateAccrualMeta implements RosettaMetaData<FloatingRateAccrual> {

	@Override
	public List<Validator<? super FloatingRateAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateAccrual> validator() {
		return new FloatingRateAccrualValidator();
	}

	@Override
	public Validator<? super FloatingRateAccrual> typeFormatValidator() {
		return new FloatingRateAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateAccrual, Set<String>> onlyExistsValidator() {
		return new FloatingRateAccrualOnlyExistsValidator();
	}
}
