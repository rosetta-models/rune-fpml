package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxSettlementRateSource;
import fpml.confirmation.validation.FxSettlementRateSourceTypeFormatValidator;
import fpml.confirmation.validation.FxSettlementRateSourceValidator;
import fpml.confirmation.validation.exists.FxSettlementRateSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxSettlementRateSource.class)
public class FxSettlementRateSourceMeta implements RosettaMetaData<FxSettlementRateSource> {

	@Override
	public List<Validator<? super FxSettlementRateSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxSettlementRateSource>create(fpml.confirmation.validation.datarule.FxSettlementRateSourceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxSettlementRateSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxSettlementRateSource> validator() {
		return new FxSettlementRateSourceValidator();
	}

	@Override
	public Validator<? super FxSettlementRateSource> typeFormatValidator() {
		return new FxSettlementRateSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSettlementRateSource, Set<String>> onlyExistsValidator() {
		return new FxSettlementRateSourceOnlyExistsValidator();
	}
}
