package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMetalGrade;
import fpml.confirmation.validation.CommodityMetalGradeTypeFormatValidator;
import fpml.confirmation.validation.CommodityMetalGradeValidator;
import fpml.confirmation.validation.exists.CommodityMetalGradeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityMetalGrade.class)
public class CommodityMetalGradeMeta implements RosettaMetaData<CommodityMetalGrade> {

	@Override
	public List<Validator<? super CommodityMetalGrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMetalGrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityMetalGrade> validator() {
		return new CommodityMetalGradeValidator();
	}

	@Override
	public Validator<? super CommodityMetalGrade> typeFormatValidator() {
		return new CommodityMetalGradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMetalGrade, Set<String>> onlyExistsValidator() {
		return new CommodityMetalGradeOnlyExistsValidator();
	}
}
