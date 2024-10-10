package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFixedPriceModelChoice;
import fpml.confirmation.validation.CommodityFixedPriceModelChoiceTypeFormatValidator;
import fpml.confirmation.validation.CommodityFixedPriceModelChoiceValidator;
import fpml.confirmation.validation.exists.CommodityFixedPriceModelChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityFixedPriceModelChoice.class)
public class CommodityFixedPriceModelChoiceMeta implements RosettaMetaData<CommodityFixedPriceModelChoice> {

	@Override
	public List<Validator<? super CommodityFixedPriceModelChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityFixedPriceModelChoice>create(fpml.confirmation.validation.datarule.CommodityFixedPriceModelChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityFixedPriceModelChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFixedPriceModelChoice> validator() {
		return new CommodityFixedPriceModelChoiceValidator();
	}

	@Override
	public Validator<? super CommodityFixedPriceModelChoice> typeFormatValidator() {
		return new CommodityFixedPriceModelChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFixedPriceModelChoice, Set<String>> onlyExistsValidator() {
		return new CommodityFixedPriceModelChoiceOnlyExistsValidator();
	}
}
