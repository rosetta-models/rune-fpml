package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalQuantityBase;
import fpml.confirmation.validation.CommodityPhysicalQuantityBaseTypeFormatValidator;
import fpml.confirmation.validation.CommodityPhysicalQuantityBaseValidator;
import fpml.confirmation.validation.exists.CommodityPhysicalQuantityBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPhysicalQuantityBase.class)
public class CommodityPhysicalQuantityBaseMeta implements RosettaMetaData<CommodityPhysicalQuantityBase> {

	@Override
	public List<Validator<? super CommodityPhysicalQuantityBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalQuantityBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPhysicalQuantityBase> validator() {
		return new CommodityPhysicalQuantityBaseValidator();
	}

	@Override
	public Validator<? super CommodityPhysicalQuantityBase> typeFormatValidator() {
		return new CommodityPhysicalQuantityBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalQuantityBase, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalQuantityBaseOnlyExistsValidator();
	}
}
