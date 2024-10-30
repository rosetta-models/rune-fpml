package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalQuantity;
import fpml.confirmation.validation.CommodityPhysicalQuantityTypeFormatValidator;
import fpml.confirmation.validation.CommodityPhysicalQuantityValidator;
import fpml.confirmation.validation.exists.CommodityPhysicalQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPhysicalQuantity.class)
public class CommodityPhysicalQuantityMeta implements RosettaMetaData<CommodityPhysicalQuantity> {

	@Override
	public List<Validator<? super CommodityPhysicalQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPhysicalQuantity> validator() {
		return new CommodityPhysicalQuantityValidator();
	}

	@Override
	public Validator<? super CommodityPhysicalQuantity> typeFormatValidator() {
		return new CommodityPhysicalQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalQuantity, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalQuantityOnlyExistsValidator();
	}
}
