package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MoneyRef;
import fpml.confirmation.validation.MoneyRefTypeFormatValidator;
import fpml.confirmation.validation.MoneyRefValidator;
import fpml.confirmation.validation.exists.MoneyRefOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MoneyRef.class)
public class MoneyRefMeta implements RosettaMetaData<MoneyRef> {

	@Override
	public List<Validator<? super MoneyRef>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MoneyRef, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MoneyRef> validator() {
		return new MoneyRefValidator();
	}

	@Override
	public Validator<? super MoneyRef> typeFormatValidator() {
		return new MoneyRefTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MoneyRef, Set<String>> onlyExistsValidator() {
		return new MoneyRefOnlyExistsValidator();
	}
}
