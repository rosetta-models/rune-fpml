package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PortfolioReferenceModel;
import fpml.confirmation.validation.PortfolioReferenceModelTypeFormatValidator;
import fpml.confirmation.validation.PortfolioReferenceModelValidator;
import fpml.confirmation.validation.exists.PortfolioReferenceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PortfolioReferenceModel.class)
public class PortfolioReferenceModelMeta implements RosettaMetaData<PortfolioReferenceModel> {

	@Override
	public List<Validator<? super PortfolioReferenceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PortfolioReferenceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PortfolioReferenceModel> validator() {
		return new PortfolioReferenceModelValidator();
	}

	@Override
	public Validator<? super PortfolioReferenceModel> typeFormatValidator() {
		return new PortfolioReferenceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioReferenceModel, Set<String>> onlyExistsValidator() {
		return new PortfolioReferenceModelOnlyExistsValidator();
	}
}
