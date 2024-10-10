package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualStrikeReference;
import fpml.confirmation.validation.FxAccrualStrikeReferenceTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualStrikeReferenceValidator;
import fpml.confirmation.validation.exists.FxAccrualStrikeReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualStrikeReference.class)
public class FxAccrualStrikeReferenceMeta implements RosettaMetaData<FxAccrualStrikeReference> {

	@Override
	public List<Validator<? super FxAccrualStrikeReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualStrikeReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualStrikeReference> validator() {
		return new FxAccrualStrikeReferenceValidator();
	}

	@Override
	public Validator<? super FxAccrualStrikeReference> typeFormatValidator() {
		return new FxAccrualStrikeReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualStrikeReference, Set<String>> onlyExistsValidator() {
		return new FxAccrualStrikeReferenceOnlyExistsValidator();
	}
}
