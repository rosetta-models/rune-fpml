package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Obligations;
import fpml.confirmation.validation.ObligationsTypeFormatValidator;
import fpml.confirmation.validation.ObligationsValidator;
import fpml.confirmation.validation.exists.ObligationsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Obligations.class)
public class ObligationsMeta implements RosettaMetaData<Obligations> {

	@Override
	public List<Validator<? super Obligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Obligations>create(fpml.confirmation.validation.datarule.ObligationsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Obligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Obligations> validator() {
		return new ObligationsValidator();
	}

	@Override
	public Validator<? super Obligations> typeFormatValidator() {
		return new ObligationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Obligations, Set<String>> onlyExistsValidator() {
		return new ObligationsOnlyExistsValidator();
	}
}
