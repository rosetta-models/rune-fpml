package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DigestValue;
import fpml.confirmation.validation.DigestValueTypeFormatValidator;
import fpml.confirmation.validation.DigestValueValidator;
import fpml.confirmation.validation.exists.DigestValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DigestValue.class)
public class DigestValueMeta implements RosettaMetaData<DigestValue> {

	@Override
	public List<Validator<? super DigestValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DigestValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DigestValue> validator() {
		return new DigestValueValidator();
	}

	@Override
	public Validator<? super DigestValue> typeFormatValidator() {
		return new DigestValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DigestValue, Set<String>> onlyExistsValidator() {
		return new DigestValueOnlyExistsValidator();
	}
}
