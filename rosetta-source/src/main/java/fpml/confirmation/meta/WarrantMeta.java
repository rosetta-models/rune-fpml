package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Warrant;
import fpml.confirmation.validation.WarrantTypeFormatValidator;
import fpml.confirmation.validation.WarrantValidator;
import fpml.confirmation.validation.exists.WarrantOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Warrant.class)
public class WarrantMeta implements RosettaMetaData<Warrant> {

	@Override
	public List<Validator<? super Warrant>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Warrant, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Warrant> validator() {
		return new WarrantValidator();
	}

	@Override
	public Validator<? super Warrant> typeFormatValidator() {
		return new WarrantTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Warrant, Set<String>> onlyExistsValidator() {
		return new WarrantOnlyExistsValidator();
	}
}
