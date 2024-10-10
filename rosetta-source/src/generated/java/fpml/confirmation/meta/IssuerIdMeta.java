package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IssuerId;
import fpml.confirmation.validation.IssuerIdTypeFormatValidator;
import fpml.confirmation.validation.IssuerIdValidator;
import fpml.confirmation.validation.exists.IssuerIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IssuerId.class)
public class IssuerIdMeta implements RosettaMetaData<IssuerId> {

	@Override
	public List<Validator<? super IssuerId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IssuerId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IssuerId> validator() {
		return new IssuerIdValidator();
	}

	@Override
	public Validator<? super IssuerId> typeFormatValidator() {
		return new IssuerIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IssuerId, Set<String>> onlyExistsValidator() {
		return new IssuerIdOnlyExistsValidator();
	}
}
