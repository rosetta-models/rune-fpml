package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Representations;
import fpml.confirmation.validation.RepresentationsTypeFormatValidator;
import fpml.confirmation.validation.RepresentationsValidator;
import fpml.confirmation.validation.exists.RepresentationsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Representations.class)
public class RepresentationsMeta implements RosettaMetaData<Representations> {

	@Override
	public List<Validator<? super Representations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Representations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Representations> validator() {
		return new RepresentationsValidator();
	}

	@Override
	public Validator<? super Representations> typeFormatValidator() {
		return new RepresentationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Representations, Set<String>> onlyExistsValidator() {
		return new RepresentationsOnlyExistsValidator();
	}
}
