package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMarketDisruption;
import fpml.confirmation.validation.CommodityMarketDisruptionTypeFormatValidator;
import fpml.confirmation.validation.CommodityMarketDisruptionValidator;
import fpml.confirmation.validation.exists.CommodityMarketDisruptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityMarketDisruption.class)
public class CommodityMarketDisruptionMeta implements RosettaMetaData<CommodityMarketDisruption> {

	@Override
	public List<Validator<? super CommodityMarketDisruption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityMarketDisruption>create(fpml.confirmation.validation.datarule.CommodityMarketDisruptionChoice0.class),
			factory.<fpml.confirmation.CommodityMarketDisruption>create(fpml.confirmation.validation.datarule.CommodityMarketDisruptionChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityMarketDisruption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityMarketDisruption> validator() {
		return new CommodityMarketDisruptionValidator();
	}

	@Override
	public Validator<? super CommodityMarketDisruption> typeFormatValidator() {
		return new CommodityMarketDisruptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMarketDisruption, Set<String>> onlyExistsValidator() {
		return new CommodityMarketDisruptionOnlyExistsValidator();
	}
}
