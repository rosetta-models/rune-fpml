package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PortfolioReferenceBaseModel;
import fpml.confirmation.validation.PortfolioReferenceBaseModelTypeFormatValidator;
import fpml.confirmation.validation.PortfolioReferenceBaseModelValidator;
import fpml.confirmation.validation.exists.PortfolioReferenceBaseModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PortfolioReferenceBaseModel.class)
public class PortfolioReferenceBaseModelMeta implements RosettaMetaData<PortfolioReferenceBaseModel> {

	@Override
	public List<Validator<? super PortfolioReferenceBaseModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PortfolioReferenceBaseModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PortfolioReferenceBaseModel> validator() {
		return new PortfolioReferenceBaseModelValidator();
	}

	@Override
	public Validator<? super PortfolioReferenceBaseModel> typeFormatValidator() {
		return new PortfolioReferenceBaseModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioReferenceBaseModel, Set<String>> onlyExistsValidator() {
		return new PortfolioReferenceBaseModelOnlyExistsValidator();
	}
}
