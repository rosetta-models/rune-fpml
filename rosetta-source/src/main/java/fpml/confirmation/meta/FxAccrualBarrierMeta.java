package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualBarrier;
import fpml.confirmation.validation.FxAccrualBarrierTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualBarrierValidator;
import fpml.confirmation.validation.exists.FxAccrualBarrierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualBarrier.class)
public class FxAccrualBarrierMeta implements RosettaMetaData<FxAccrualBarrier> {

	@Override
	public List<Validator<? super FxAccrualBarrier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxAccrualBarrier>create(fpml.confirmation.validation.datarule.FxAccrualBarrierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualBarrier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualBarrier> validator() {
		return new FxAccrualBarrierValidator();
	}

	@Override
	public Validator<? super FxAccrualBarrier> typeFormatValidator() {
		return new FxAccrualBarrierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualBarrier, Set<String>> onlyExistsValidator() {
		return new FxAccrualBarrierOnlyExistsValidator();
	}
}
