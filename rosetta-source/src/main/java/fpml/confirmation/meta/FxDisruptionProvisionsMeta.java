package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDisruptionProvisions;
import fpml.confirmation.validation.FxDisruptionProvisionsTypeFormatValidator;
import fpml.confirmation.validation.FxDisruptionProvisionsValidator;
import fpml.confirmation.validation.exists.FxDisruptionProvisionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxDisruptionProvisions.class)
public class FxDisruptionProvisionsMeta implements RosettaMetaData<FxDisruptionProvisions> {

	@Override
	public List<Validator<? super FxDisruptionProvisions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDisruptionProvisions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxDisruptionProvisions> validator() {
		return new FxDisruptionProvisionsValidator();
	}

	@Override
	public Validator<? super FxDisruptionProvisions> typeFormatValidator() {
		return new FxDisruptionProvisionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDisruptionProvisions, Set<String>> onlyExistsValidator() {
		return new FxDisruptionProvisionsOnlyExistsValidator();
	}
}
