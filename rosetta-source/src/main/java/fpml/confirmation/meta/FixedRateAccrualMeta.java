package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedRateAccrual;
import fpml.confirmation.validation.FixedRateAccrualTypeFormatValidator;
import fpml.confirmation.validation.FixedRateAccrualValidator;
import fpml.confirmation.validation.exists.FixedRateAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FixedRateAccrual.class)
public class FixedRateAccrualMeta implements RosettaMetaData<FixedRateAccrual> {

	@Override
	public List<Validator<? super FixedRateAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedRateAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedRateAccrual> validator() {
		return new FixedRateAccrualValidator();
	}

	@Override
	public Validator<? super FixedRateAccrual> typeFormatValidator() {
		return new FixedRateAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRateAccrual, Set<String>> onlyExistsValidator() {
		return new FixedRateAccrualOnlyExistsValidator();
	}
}
