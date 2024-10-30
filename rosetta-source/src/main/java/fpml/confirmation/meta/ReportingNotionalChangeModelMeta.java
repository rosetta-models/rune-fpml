package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingNotionalChangeModel;
import fpml.confirmation.validation.ReportingNotionalChangeModelTypeFormatValidator;
import fpml.confirmation.validation.ReportingNotionalChangeModelValidator;
import fpml.confirmation.validation.exists.ReportingNotionalChangeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReportingNotionalChangeModel.class)
public class ReportingNotionalChangeModelMeta implements RosettaMetaData<ReportingNotionalChangeModel> {

	@Override
	public List<Validator<? super ReportingNotionalChangeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ReportingNotionalChangeModel>create(fpml.confirmation.validation.datarule.ReportingNotionalChangeModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReportingNotionalChangeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingNotionalChangeModel> validator() {
		return new ReportingNotionalChangeModelValidator();
	}

	@Override
	public Validator<? super ReportingNotionalChangeModel> typeFormatValidator() {
		return new ReportingNotionalChangeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingNotionalChangeModel, Set<String>> onlyExistsValidator() {
		return new ReportingNotionalChangeModelOnlyExistsValidator();
	}
}
