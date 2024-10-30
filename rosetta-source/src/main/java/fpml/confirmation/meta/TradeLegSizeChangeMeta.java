package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeLegSizeChange;
import fpml.confirmation.validation.TradeLegSizeChangeTypeFormatValidator;
import fpml.confirmation.validation.TradeLegSizeChangeValidator;
import fpml.confirmation.validation.exists.TradeLegSizeChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeLegSizeChange.class)
public class TradeLegSizeChangeMeta implements RosettaMetaData<TradeLegSizeChange> {

	@Override
	public List<Validator<? super TradeLegSizeChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeLegSizeChange>create(fpml.confirmation.validation.datarule.TradeLegSizeChangeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeLegSizeChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeLegSizeChange> validator() {
		return new TradeLegSizeChangeValidator();
	}

	@Override
	public Validator<? super TradeLegSizeChange> typeFormatValidator() {
		return new TradeLegSizeChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeLegSizeChange, Set<String>> onlyExistsValidator() {
		return new TradeLegSizeChangeOnlyExistsValidator();
	}
}
