package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConstituentWeight;
import fpml.confirmation.validation.ConstituentWeightTypeFormatValidator;
import fpml.confirmation.validation.ConstituentWeightValidator;
import fpml.confirmation.validation.exists.ConstituentWeightOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ConstituentWeight.class)
public class ConstituentWeightMeta implements RosettaMetaData<ConstituentWeight> {

	@Override
	public List<Validator<? super ConstituentWeight>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConstituentWeight, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConstituentWeight> validator() {
		return new ConstituentWeightValidator();
	}

	@Override
	public Validator<? super ConstituentWeight> typeFormatValidator() {
		return new ConstituentWeightTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConstituentWeight, Set<String>> onlyExistsValidator() {
		return new ConstituentWeightOnlyExistsValidator();
	}
}
