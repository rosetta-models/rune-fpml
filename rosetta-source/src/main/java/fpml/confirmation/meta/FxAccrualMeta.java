package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrual;
import fpml.confirmation.validation.FxAccrualTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualValidator;
import fpml.confirmation.validation.exists.FxAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrual.class)
public class FxAccrualMeta implements RosettaMetaData<FxAccrual> {

	@Override
	public List<Validator<? super FxAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrual> validator() {
		return new FxAccrualValidator();
	}

	@Override
	public Validator<? super FxAccrual> typeFormatValidator() {
		return new FxAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrual, Set<String>> onlyExistsValidator() {
		return new FxAccrualOnlyExistsValidator();
	}
}
