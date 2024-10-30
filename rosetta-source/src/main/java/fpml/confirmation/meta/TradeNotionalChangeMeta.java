package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeNotionalChange;
import fpml.confirmation.validation.TradeNotionalChangeTypeFormatValidator;
import fpml.confirmation.validation.TradeNotionalChangeValidator;
import fpml.confirmation.validation.exists.TradeNotionalChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeNotionalChange.class)
public class TradeNotionalChangeMeta implements RosettaMetaData<TradeNotionalChange> {

	@Override
	public List<Validator<? super TradeNotionalChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeChangeBase>create(fpml.confirmation.validation.datarule.TradeChangeBaseChoice.class),
			factory.<fpml.confirmation.TradeNotionalChange>create(fpml.confirmation.validation.datarule.TradeNotionalChangeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeNotionalChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeNotionalChange> validator() {
		return new TradeNotionalChangeValidator();
	}

	@Override
	public Validator<? super TradeNotionalChange> typeFormatValidator() {
		return new TradeNotionalChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeNotionalChange, Set<String>> onlyExistsValidator() {
		return new TradeNotionalChangeOnlyExistsValidator();
	}
}
