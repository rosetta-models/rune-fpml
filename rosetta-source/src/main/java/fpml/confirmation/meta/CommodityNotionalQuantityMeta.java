package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.validation.CommodityNotionalQuantityTypeFormatValidator;
import fpml.confirmation.validation.CommodityNotionalQuantityValidator;
import fpml.confirmation.validation.exists.CommodityNotionalQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityNotionalQuantity.class)
public class CommodityNotionalQuantityMeta implements RosettaMetaData<CommodityNotionalQuantity> {

	@Override
	public List<Validator<? super CommodityNotionalQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityNotionalQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityNotionalQuantity> validator() {
		return new CommodityNotionalQuantityValidator();
	}

	@Override
	public Validator<? super CommodityNotionalQuantity> typeFormatValidator() {
		return new CommodityNotionalQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityNotionalQuantity, Set<String>> onlyExistsValidator() {
		return new CommodityNotionalQuantityOnlyExistsValidator();
	}
}
