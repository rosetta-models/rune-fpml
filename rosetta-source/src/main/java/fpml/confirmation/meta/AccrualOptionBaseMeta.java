package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualOptionBase;
import fpml.confirmation.validation.AccrualOptionBaseTypeFormatValidator;
import fpml.confirmation.validation.AccrualOptionBaseValidator;
import fpml.confirmation.validation.exists.AccrualOptionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccrualOptionBase.class)
public class AccrualOptionBaseMeta implements RosettaMetaData<AccrualOptionBase> {

	@Override
	public List<Validator<? super AccrualOptionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccrualOptionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccrualOptionBase> validator() {
		return new AccrualOptionBaseValidator();
	}

	@Override
	public Validator<? super AccrualOptionBase> typeFormatValidator() {
		return new AccrualOptionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccrualOptionBase, Set<String>> onlyExistsValidator() {
		return new AccrualOptionBaseOnlyExistsValidator();
	}
}
