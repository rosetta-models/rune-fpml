package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityProductGrade;
import fpml.confirmation.validation.CommodityProductGradeTypeFormatValidator;
import fpml.confirmation.validation.CommodityProductGradeValidator;
import fpml.confirmation.validation.exists.CommodityProductGradeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityProductGrade.class)
public class CommodityProductGradeMeta implements RosettaMetaData<CommodityProductGrade> {

	@Override
	public List<Validator<? super CommodityProductGrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityProductGrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityProductGrade> validator() {
		return new CommodityProductGradeValidator();
	}

	@Override
	public Validator<? super CommodityProductGrade> typeFormatValidator() {
		return new CommodityProductGradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityProductGrade, Set<String>> onlyExistsValidator() {
		return new CommodityProductGradeOnlyExistsValidator();
	}
}
