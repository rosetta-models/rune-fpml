package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PortfolioConstituentReferenceModel;
import fpml.confirmation.validation.PortfolioConstituentReferenceModelTypeFormatValidator;
import fpml.confirmation.validation.PortfolioConstituentReferenceModelValidator;
import fpml.confirmation.validation.exists.PortfolioConstituentReferenceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PortfolioConstituentReferenceModel.class)
public class PortfolioConstituentReferenceModelMeta implements RosettaMetaData<PortfolioConstituentReferenceModel> {

	@Override
	public List<Validator<? super PortfolioConstituentReferenceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PortfolioConstituentReferenceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PortfolioConstituentReferenceModel> validator() {
		return new PortfolioConstituentReferenceModelValidator();
	}

	@Override
	public Validator<? super PortfolioConstituentReferenceModel> typeFormatValidator() {
		return new PortfolioConstituentReferenceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioConstituentReferenceModel, Set<String>> onlyExistsValidator() {
		return new PortfolioConstituentReferenceModelOnlyExistsValidator();
	}
}
