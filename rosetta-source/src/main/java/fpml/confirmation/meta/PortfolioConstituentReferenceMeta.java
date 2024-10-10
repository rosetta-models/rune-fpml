package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PortfolioConstituentReference;
import fpml.confirmation.validation.PortfolioConstituentReferenceTypeFormatValidator;
import fpml.confirmation.validation.PortfolioConstituentReferenceValidator;
import fpml.confirmation.validation.exists.PortfolioConstituentReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PortfolioConstituentReference.class)
public class PortfolioConstituentReferenceMeta implements RosettaMetaData<PortfolioConstituentReference> {

	@Override
	public List<Validator<? super PortfolioConstituentReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PortfolioConstituentReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PortfolioConstituentReference> validator() {
		return new PortfolioConstituentReferenceValidator();
	}

	@Override
	public Validator<? super PortfolioConstituentReference> typeFormatValidator() {
		return new PortfolioConstituentReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioConstituentReference, Set<String>> onlyExistsValidator() {
		return new PortfolioConstituentReferenceOnlyExistsValidator();
	}
}
