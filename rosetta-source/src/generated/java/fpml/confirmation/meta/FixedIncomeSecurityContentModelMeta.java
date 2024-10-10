package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.validation.FixedIncomeSecurityContentModelTypeFormatValidator;
import fpml.confirmation.validation.FixedIncomeSecurityContentModelValidator;
import fpml.confirmation.validation.exists.FixedIncomeSecurityContentModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FixedIncomeSecurityContentModel.class)
public class FixedIncomeSecurityContentModelMeta implements RosettaMetaData<FixedIncomeSecurityContentModel> {

	@Override
	public List<Validator<? super FixedIncomeSecurityContentModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FixedIncomeSecurityContentModel>create(fpml.confirmation.validation.datarule.FixedIncomeSecurityContentModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FixedIncomeSecurityContentModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedIncomeSecurityContentModel> validator() {
		return new FixedIncomeSecurityContentModelValidator();
	}

	@Override
	public Validator<? super FixedIncomeSecurityContentModel> typeFormatValidator() {
		return new FixedIncomeSecurityContentModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedIncomeSecurityContentModel, Set<String>> onlyExistsValidator() {
		return new FixedIncomeSecurityContentModelOnlyExistsValidator();
	}
}
