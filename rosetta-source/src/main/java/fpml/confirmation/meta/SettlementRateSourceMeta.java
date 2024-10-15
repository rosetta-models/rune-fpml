package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementRateSource;
import fpml.confirmation.validation.SettlementRateSourceTypeFormatValidator;
import fpml.confirmation.validation.SettlementRateSourceValidator;
import fpml.confirmation.validation.exists.SettlementRateSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SettlementRateSource.class)
public class SettlementRateSourceMeta implements RosettaMetaData<SettlementRateSource> {

	@Override
	public List<Validator<? super SettlementRateSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.SettlementRateSource>create(fpml.confirmation.validation.datarule.SettlementRateSourceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementRateSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementRateSource> validator() {
		return new SettlementRateSourceValidator();
	}

	@Override
	public Validator<? super SettlementRateSource> typeFormatValidator() {
		return new SettlementRateSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementRateSource, Set<String>> onlyExistsValidator() {
		return new SettlementRateSourceOnlyExistsValidator();
	}
}
