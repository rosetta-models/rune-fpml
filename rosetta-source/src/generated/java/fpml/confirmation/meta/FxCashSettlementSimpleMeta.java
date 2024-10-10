package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.validation.FxCashSettlementSimpleTypeFormatValidator;
import fpml.confirmation.validation.FxCashSettlementSimpleValidator;
import fpml.confirmation.validation.exists.FxCashSettlementSimpleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxCashSettlementSimple.class)
public class FxCashSettlementSimpleMeta implements RosettaMetaData<FxCashSettlementSimple> {

	@Override
	public List<Validator<? super FxCashSettlementSimple>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxCashSettlementSimple>create(fpml.confirmation.validation.datarule.FxCashSettlementSimpleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxCashSettlementSimple, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxCashSettlementSimple> validator() {
		return new FxCashSettlementSimpleValidator();
	}

	@Override
	public Validator<? super FxCashSettlementSimple> typeFormatValidator() {
		return new FxCashSettlementSimpleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCashSettlementSimple, Set<String>> onlyExistsValidator() {
		return new FxCashSettlementSimpleOnlyExistsValidator();
	}
}
