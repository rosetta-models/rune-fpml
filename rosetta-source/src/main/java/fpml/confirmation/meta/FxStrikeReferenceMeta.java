package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxStrikeReference;
import fpml.confirmation.validation.FxStrikeReferenceTypeFormatValidator;
import fpml.confirmation.validation.FxStrikeReferenceValidator;
import fpml.confirmation.validation.exists.FxStrikeReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxStrikeReference.class)
public class FxStrikeReferenceMeta implements RosettaMetaData<FxStrikeReference> {

	@Override
	public List<Validator<? super FxStrikeReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxStrikeReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxStrikeReference> validator() {
		return new FxStrikeReferenceValidator();
	}

	@Override
	public Validator<? super FxStrikeReference> typeFormatValidator() {
		return new FxStrikeReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxStrikeReference, Set<String>> onlyExistsValidator() {
		return new FxStrikeReferenceOnlyExistsValidator();
	}
}
