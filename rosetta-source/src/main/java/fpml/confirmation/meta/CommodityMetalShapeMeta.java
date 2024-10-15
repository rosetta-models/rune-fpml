package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMetalShape;
import fpml.confirmation.validation.CommodityMetalShapeTypeFormatValidator;
import fpml.confirmation.validation.CommodityMetalShapeValidator;
import fpml.confirmation.validation.exists.CommodityMetalShapeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityMetalShape.class)
public class CommodityMetalShapeMeta implements RosettaMetaData<CommodityMetalShape> {

	@Override
	public List<Validator<? super CommodityMetalShape>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMetalShape, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityMetalShape> validator() {
		return new CommodityMetalShapeValidator();
	}

	@Override
	public Validator<? super CommodityMetalShape> typeFormatValidator() {
		return new CommodityMetalShapeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMetalShape, Set<String>> onlyExistsValidator() {
		return new CommodityMetalShapeOnlyExistsValidator();
	}
}
