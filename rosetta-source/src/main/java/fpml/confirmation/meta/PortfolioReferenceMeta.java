package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PortfolioReference;
import fpml.confirmation.validation.PortfolioReferenceTypeFormatValidator;
import fpml.confirmation.validation.PortfolioReferenceValidator;
import fpml.confirmation.validation.exists.PortfolioReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PortfolioReference.class)
public class PortfolioReferenceMeta implements RosettaMetaData<PortfolioReference> {

	@Override
	public List<Validator<? super PortfolioReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PortfolioReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PortfolioReference> validator() {
		return new PortfolioReferenceValidator();
	}

	@Override
	public Validator<? super PortfolioReference> typeFormatValidator() {
		return new PortfolioReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioReference, Set<String>> onlyExistsValidator() {
		return new PortfolioReferenceOnlyExistsValidator();
	}
}
