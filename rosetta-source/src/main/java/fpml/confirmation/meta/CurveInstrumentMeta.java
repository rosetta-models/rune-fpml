package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CurveInstrument;
import fpml.confirmation.validation.CurveInstrumentTypeFormatValidator;
import fpml.confirmation.validation.CurveInstrumentValidator;
import fpml.confirmation.validation.exists.CurveInstrumentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CurveInstrument.class)
public class CurveInstrumentMeta implements RosettaMetaData<CurveInstrument> {

	@Override
	public List<Validator<? super CurveInstrument>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CurveInstrument, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CurveInstrument> validator() {
		return new CurveInstrumentValidator();
	}

	@Override
	public Validator<? super CurveInstrument> typeFormatValidator() {
		return new CurveInstrumentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CurveInstrument, Set<String>> onlyExistsValidator() {
		return new CurveInstrumentOnlyExistsValidator();
	}
}
