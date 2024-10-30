package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericCommodityGrade;
import fpml.confirmation.validation.GenericCommodityGradeTypeFormatValidator;
import fpml.confirmation.validation.GenericCommodityGradeValidator;
import fpml.confirmation.validation.exists.GenericCommodityGradeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GenericCommodityGrade.class)
public class GenericCommodityGradeMeta implements RosettaMetaData<GenericCommodityGrade> {

	@Override
	public List<Validator<? super GenericCommodityGrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericCommodityGrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericCommodityGrade> validator() {
		return new GenericCommodityGradeValidator();
	}

	@Override
	public Validator<? super GenericCommodityGrade> typeFormatValidator() {
		return new GenericCommodityGradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericCommodityGrade, Set<String>> onlyExistsValidator() {
		return new GenericCommodityGradeOnlyExistsValidator();
	}
}
