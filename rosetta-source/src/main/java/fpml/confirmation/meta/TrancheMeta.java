package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Tranche;
import fpml.confirmation.validation.TrancheTypeFormatValidator;
import fpml.confirmation.validation.TrancheValidator;
import fpml.confirmation.validation.exists.TrancheOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Tranche.class)
public class TrancheMeta implements RosettaMetaData<Tranche> {

	@Override
	public List<Validator<? super Tranche>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Tranche, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Tranche> validator() {
		return new TrancheValidator();
	}

	@Override
	public Validator<? super Tranche> typeFormatValidator() {
		return new TrancheTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Tranche, Set<String>> onlyExistsValidator() {
		return new TrancheOnlyExistsValidator();
	}
}
