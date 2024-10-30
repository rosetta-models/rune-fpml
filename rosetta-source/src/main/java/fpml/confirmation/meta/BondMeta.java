package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Bond;
import fpml.confirmation.validation.BondTypeFormatValidator;
import fpml.confirmation.validation.BondValidator;
import fpml.confirmation.validation.exists.BondOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Bond.class)
public class BondMeta implements RosettaMetaData<Bond> {

	@Override
	public List<Validator<? super Bond>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Bond, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Bond> validator() {
		return new BondValidator();
	}

	@Override
	public Validator<? super Bond> typeFormatValidator() {
		return new BondTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Bond, Set<String>> onlyExistsValidator() {
		return new BondOnlyExistsValidator();
	}
}
