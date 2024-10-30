package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxRangeAccrual;
import fpml.confirmation.validation.FxRangeAccrualTypeFormatValidator;
import fpml.confirmation.validation.FxRangeAccrualValidator;
import fpml.confirmation.validation.exists.FxRangeAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxRangeAccrual.class)
public class FxRangeAccrualMeta implements RosettaMetaData<FxRangeAccrual> {

	@Override
	public List<Validator<? super FxRangeAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxRangeAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxRangeAccrual> validator() {
		return new FxRangeAccrualValidator();
	}

	@Override
	public Validator<? super FxRangeAccrual> typeFormatValidator() {
		return new FxRangeAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRangeAccrual, Set<String>> onlyExistsValidator() {
		return new FxRangeAccrualOnlyExistsValidator();
	}
}
