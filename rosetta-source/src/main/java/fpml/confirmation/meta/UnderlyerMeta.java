package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Underlyer;
import fpml.confirmation.validation.UnderlyerTypeFormatValidator;
import fpml.confirmation.validation.UnderlyerValidator;
import fpml.confirmation.validation.exists.UnderlyerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Underlyer.class)
public class UnderlyerMeta implements RosettaMetaData<Underlyer> {

	@Override
	public List<Validator<? super Underlyer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Underlyer>create(fpml.confirmation.validation.datarule.UnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Underlyer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Underlyer> validator() {
		return new UnderlyerValidator();
	}

	@Override
	public Validator<? super Underlyer> typeFormatValidator() {
		return new UnderlyerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Underlyer, Set<String>> onlyExistsValidator() {
		return new UnderlyerOnlyExistsValidator();
	}
}
