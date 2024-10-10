package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.validation.CommodityPremiumTypeFormatValidator;
import fpml.confirmation.validation.CommodityPremiumValidator;
import fpml.confirmation.validation.exists.CommodityPremiumOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityPremium.class)
public class CommodityPremiumMeta implements RosettaMetaData<CommodityPremium> {

	@Override
	public List<Validator<? super CommodityPremium>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPremium, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPremium> validator() {
		return new CommodityPremiumValidator();
	}

	@Override
	public Validator<? super CommodityPremium> typeFormatValidator() {
		return new CommodityPremiumTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPremium, Set<String>> onlyExistsValidator() {
		return new CommodityPremiumOnlyExistsValidator();
	}
}
